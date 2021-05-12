/** RunStudRegGui.java
 * This is a subclass of Student
 * Author: Bradley van der Westhuizen (217218903
 * Date: 18 April 2019
 */
package runstudreggui;

public class Graduate extends Student
{
    private String qualification;
    private double fee;

    public Graduate() 
    {
        
    }

    public Graduate(String iD, String name, int score, String qualification, double fee) 
    {
        super(iD, name, score);
        this.qualification = qualification;
        this.fee = fee;
    }

    public String getQualification() 
    {
        return qualification;
    }

    public double getFee() 
    {
        return fee;
    }

    public void setQualification(String qualification) 
    {
        this.qualification = qualification;
    }

    public void setFee(double fee) 
    {
        this.fee = fee;
    }

    @Override
    public String toString() 
    {
        String output;
        output = String.format("ID: %s, Surname: %s, Score: %d, Qualification: %s, Fee: %.2f", getiD(), getName(), getScore(), qualification, fee);
        return output;    
    }
}
