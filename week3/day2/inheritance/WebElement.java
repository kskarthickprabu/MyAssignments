package org.testleaf.week3.day2.inheritance;
// base class
public class WebElement {
    static String Text="WebElement Class setText method accessed from Elements Class";
    // common methods

    public void click(){

        System.out.println("WebElement Class click method accessed from Elements Class");

    }
   public void setText(String Text){
    
    System.out.println(Text);

   }


}
