import java.util.Scanner;

public class Example
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Ready...");
		printBlankArrow();
		Thread.sleep(1200);
		System.out.println("Aim...");
		printBlankArrow();
		Thread.sleep(1200);
		System.out.println("(and then)");
		printBlankArrow();

		Scanner inp = new Scanner(System.in);
		String line;

		while ((line = inp.nextLine()) != null && !line.equalsIgnoreCase("fire"))
		{
			System.out.println("Hmm?");
		}
		System.out.println("Fire!");

		for(int i=-5; i<30; i++)
		{
			StringBuilder stringBuilder = new StringBuilder();
			if(i<0)
			{
				stringBuilder.append("<}");
				for (int j = 0; j < 31; j++)
				{
					stringBuilder.append(' ');
				}
				stringBuilder.append("#");
			}
			else if(i<29)
			{
				stringBuilder.append(" }");
				for (int j = 0; j < i; j++)
				{
					stringBuilder.append(' ');
				}
				stringBuilder.append("->");
				for (int j = i; j < 29; j++)
				{
					stringBuilder.append(' ');
				}
				stringBuilder.append('#');
			}
			else
			{
				stringBuilder.append(" }");
				for (int j = 0; j < 31; j++)
				{
					stringBuilder.append(' ');
				}
				stringBuilder.append("*");
			}

			System.out.println(stringBuilder.toString());
			Thread.sleep(70);
		}
	}

	private static void printBlankArrow()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<}");
		for (int j = 0; j < 31; j++)
		{
			stringBuilder.append(' ');
		}
		stringBuilder.append("#");
		System.out.println(stringBuilder.toString());
	}
}
