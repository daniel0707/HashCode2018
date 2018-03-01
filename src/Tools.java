public class Tools {

    static int distance(int startX, int startY, int endX, int endY){
        return Math.abs(startX - endX)+Math.abs(startY - endY);
    }

    static int distToStart(int startX, int startY){
        return startX+startY;
    }

    static boolean canWeReachInTime(int startX, int startY,int endX, int endY, int stepStart, int stepEnd){
        return distance(startX, startY, endX, endY)<=(stepEnd-stepStart)? true : false;
    }

    static boolean canWeDoItInTime(int myPosX, int myPosY, int startX, int startY, int endX, int endY, int currentStep, int stepEnd){
        return (Math.abs(myPosX - startX)+Math.abs(myPosY - startY) + Math.abs(startX - endX) + Math.abs(startY - endY))<=(stepEnd - currentStep)? true : false;
    }

}
