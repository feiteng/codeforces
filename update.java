// update list of completed questions in markdown file 
import java.math.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import org.json.*;

 
public class update
{

	static List<Question> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter writer;
	static Map<String, List<String>> questionTags = new HashMap<>();
	static Map<String, Integer> questionRatings = new HashMap<>();

	public static void main(String[] args) throws Exception
	{
		loadQuestions();
		File[] files = new File("../codeforces/").listFiles();
		writer = new BufferedWriter(new FileWriter("README.md"));
		writeToFiles(files);
		Collections.sort(list);
		sb.append("|Count|Contest|Question|Submission Link|Last Modified|Rank|Tags|\n" + 
			"|-|-|-|-|-|-|-|\n");
		int count = 1;
		for(Question q : list)
			sb.append("|" + count++ + "|" + q.contest + "|" + q.question 
					+ "|" + getLink(q.submissionLink) + "|" + q.lastModified + "|"
					+ q.rating + "|" + q.tags + "|\n");
		System.out.printf("%s\n", sb.toString());
		writer.write(sb.toString());
		writer.close();
	}

	static void loadQuestions() throws Exception
	{
		String jsonFile = "problemset.json";
		JSONTokener tokener = new JSONTokener(new FileReader(jsonFile));
		JSONObject root = new JSONObject(tokener);
		root = (JSONObject) root.get("result");
		JSONArray array = (JSONArray) root.get("problems");
		
		Iterator<Object> itor = array.iterator();
		while(itor.hasNext())
		{
			JSONObject eachQuestion = (JSONObject) itor.next();
			
			try{
				JSONArray tags = (JSONArray) eachQuestion.get("tags");
				String index = (String) eachQuestion.get("index");
				int contestID = (Integer) eachQuestion.get("contestId");
				String questionID = "" + contestID + index; 
				
				if(!questionTags.containsKey(questionID))
					questionTags.put(questionID, new ArrayList<>());
				
				Iterator<Object> itt = tags.iterator();
				while(itt.hasNext())
				{
					questionTags.get(questionID).add((String) itt.next());
				}

				int rating = (Integer) eachQuestion.get("rating");
				questionRatings.put(questionID, rating);
			}
			catch(Exception e)
			{
				continue;
			}
			
			
		}

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
					list.add(new Question(file, questionTags, questionRatings));
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
		int contest, rating = -1;
		String question, lastModified, submissionLink;
		long lastModifiedTime;
		List<String> tags = new ArrayList<>();


		public Question(File file, 
				Map<String, List<String>> questionTags,
				Map<String, Integer> questionRatings) throws Exception
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

				String questionID = "" + contest + question;
				// System.out.println(questionID);
				rating = questionRatings.get(questionID);
				tags = questionTags.get(questionID);
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

