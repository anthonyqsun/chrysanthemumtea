// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 15 hours

/**
 * collection of ANSI control codes and other handy lil' tricks for terminal enlivenation
 * 
 * orginated by sk, tweaked by tm
 **/

public class TerminallyIll
{
  private static final int BRIGHT = 1;
  private static final int DARK = 2;
  private static final int ITALICS = 3;
  private static final int BLACK = 30;
  private static final int RED = 31;
  private static final int GREEN = 32;
  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int MAGENTA = 35;
  private static final int CYAN = 36;
  private static final int WHITE = 37;
  private static final String CLEAR_SCREEN =  "\033[2J";
  private static final String HIDE_CURSOR =  "\033[?25l";
  private static final String SHOW_CURSOR =  "\033[?25h";

  //use this to go back to normal terminal colors
  private static final String RESET = color(40,37)+SHOW_CURSOR;

  //use this to convert from color to background (30 to 37 becomes 40 to 47)
  public static int background(int color)
  {
    return color + 10;
  }

  //terminal specific character to move the cursor to a location
  //top left is 1,1
  private static String go(int x, int y)
  {
    return ("\033[" + x + ";" + y + "H");
  }

  public static String color(int a, int b)
  {
    return ("\033[0;" + a+ ";" + b + "m");
  }
  public static String color(int a, int b, int c)
  {
    return ("\033[0;" + a+ ";" + b + ";" + c+ "m");
  }
  public static String color(int a, int b, int c, int d)
  {
    return ("\033[0;" + a+ ";" + b + ";" + c + ";" + d + "m");
  }

  public static void clearAndReset() {
    System.out.print(CLEAR_SCREEN);
    System.out.print(go(0, 0));
  }

  //delay printing...
  public static void wait(int millis)
  {
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
}