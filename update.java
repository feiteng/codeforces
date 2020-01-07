// update list of completed questions in markdown file 
import java.math.*;
import java.util.*;
import java.io.*;
 
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
		sb.append("|Contest|Question|Rank|\n|-|-|-|\n");
		int count = 1;
		for(Question q : list)
			sb.append("|" + count++ + "|" + q.contest + "|" + q.question + "|\n");
		System.out.printf("%s\n", sb.toString());
		writer.write(sb.toString());
		writer.close();
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
				String str = file.toString();
				if(str.endsWith(".java"))
				{
					// this is a file
					String[] split = str.split("\\\\");
					try
					{
						int n = split.length;
						String contestStr = split[n - 2],
							questionStr = split[n - 1];
						int contest = -1;
					
						contest = Integer.valueOf(contestStr);
						list.add(new Question(contest, "" + questionStr.charAt(0)));
					}
					catch (Exception e)
					{
						continue;
					}

				}
				// System.out.println(file);
			}
		}
	}	
}
class Question implements Comparable<Question>
	{
		int contest, rank = -1;
		String question;
		public Question(int con, String q)
		{
			contest = con;
			question = q;
		}

		public int compareTo(Question v) {
			if(this.contest != v.contest) return this.contest - v.contest;
			return this.question.compareTo(v.question);
		}
	}