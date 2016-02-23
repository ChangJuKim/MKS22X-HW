public class Driver{
    public static boolean close(double a,double b){
        if(a == 0.0 && b == 0.0){
            return true;
        }
        if(a == 0.0){
            return close(b,a);
        }
        return Math.abs(a-b)/a < 0.00001;
    }
    public static void main(String[]args){

        Recursion a = new Recursion();
        int score = 0;
        /*run calculations*/
        double[] testvalues={1,2,4,100,0.0000001,-1,-100,0};
        System.out.println("Start: "+a.name());
        for(int i=0;i<testvalues.length;i++){
            try{
                if( close(a.sqrt(testvalues[i]),Math.sqrt(testvalues[i]))){
                    System.out.println("PASS! sqrt("+testvalues[i]);
                    score++;
                }else{
                    System.out.println("-----XXX Failed sqrt("+testvalues[i]);
                }
            }catch(IllegalArgumentException e){
                if(testvalues[i] < 0){
                    System.out.println("PASS! sqrt("+testvalues[i]);
                    score++;
                }else{
                    System.out.println("UNHANDLED Illegal Argument - Failed sqrt("+testvalues[i]);
                }
            }catch(Exception e){
            System.out.println("Exception Failed sqrt("+testvalues[i]);
            }
        }
        System.out.println("SCORE "+a.name()+"\t"+score+" / "+testvalues.length+"\n");
    }
}
