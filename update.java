// update list of completed questions in markdown file 
import java.math.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;

 
class update
{

	static List<Question> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter writer;
	public static void main(String[] args) throws Exception
	{
		File[] files = new File("../codeforces/").listFiles();
		writer = new BufferedWriter(new FileWriter("README.md"));
		writeToFiles(files);
		Collections.sort(list);
		sb.append("|Count|Contest|Question|Submission Link|Last Modified|Rank|\n" + 
			"|-|-|-|-|-|-|\n");
		int count = 1;
		for(Question q : list)
			sb.append("|" + count++ + "|" + q.contest + "|" + q.question 
					+ "|" + getLink(q.submissionLink) + "|" + q.lastModified + "|#|\n");
		System.out.printf("%s\n", sb.toString());
		writer.write(sb.toString());
		writer.close();
	}

	static String getLink(String str)
	{
		if(str.length() < 2) return str;
		int pos = str.lastIndexOf("/"),
			n = str.length();
		String sub = str.substring(pos + 1, n);
		return "[" + sub + "](" + str + ")";
	}

	static void writeToFiles(File[] files) throws Exception
	{
		for(File file : files) 
		{
			if(file.isDirectory())
			{
				writeToFiles(file.listFiles());
			}
			else
			{
				try
				{
					list.add(new Question(file));
				}
				catch (Exception e)
				{
					continue;
				}

			}
		}	
	}
}

class Question implements Comparable<Question>
{
		int contest, rank = -1;
		String question, lastModified, submissionLink;
		long lastModifiedTime;


		public Question(File file) throws Exception
		{
			String str = file.toString();
			
			if(str.endsWith(".java"))
			{
				// this is a file
				String[] split = str.split("\\\\");
				int n = split.length;
				String contestStr = split[n - 2];
				
				question = "" + split[n - 1].charAt(0);
				contest = Integer.valueOf(contestStr);

				
				lastModifiedTime = file.lastModified();				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				lastModified = sdf.format(lastModifiedTime);

				submissionLink = getLink(file);
			}
			else throw new Exception();
		}

		public int compareTo(Question v) {
			if(this.contest != v.contest) return this.contest - v.contest;
			return this.question.compareTo(v.question);
		}

		String getLink(File file) throws Exception
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			return line.substring(3);
		}
}
