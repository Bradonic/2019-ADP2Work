/** RunStudRegGui.java
 * This is the Student class
 * Author: Bradley van der Westhuizen (217218903
 * Date: 18 April 2019
 */
package runstudreggui;

public class Student 
{
    private String iD;
    private String name;
    private int score;

    public Student() 
    {
        
    }

    public Student(String iD, String name, int score) 
    {
        this.iD = iD;
        this.name = name;
        this.score = score;
    }

    public String getiD() 
    {
        return iD;
    }

    public String getName() 
    {
        return name;
    }

    public int getScore() 
    {
        return score;
    }

    public void setiD(String iD)
    {
        this.iD = iD;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setScore(int score) 
    {
        this.score = score;
    }

    @Override
    public String toString() 
    {
        return "Student{" + "iD=" + iD + ", name=" + name + ", score=" + score + '}';
    }
}
