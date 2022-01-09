enum Direction  {NORTH, SOUTH, EAST, WEST}
enum Instruction {LEFT, RIGHT, FORWARD}
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
    }

    public boolean isRobotBounded(String instructions) {
        Robot robot = new Robot(0,0,Direction.NORTH);
        for(int i=0;i<instructions.length();i++){
            char instruction = instructions.charAt(i);
            if(instruction=='G'){
                robot.followInstructions(Instruction.FORWARD);
            } else if (instruction == 'L') {
                robot.followInstructions(Instruction.LEFT);
            }else{
                robot.followInstructions(Instruction.RIGHT);
            }
        }
        if(robot.getY()==0 && robot.getX()==0) return true;
        else if(robot.getCurrentDirection().equals(Direction.NORTH)) return false;
        return true;
    }
}
class Robot{
    private int x;
    private int y;
    private Direction currentDirection;

    public Robot(int x, int y, Direction currentDirection){
        this.x = x;
        this.y = y;
        this.currentDirection = currentDirection;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void followInstructions(Instruction instruction){
        if(instruction.equals(Instruction.LEFT)){
            if(currentDirection.equals(Direction.NORTH)){
                currentDirection = Direction.EAST;
            }
            else if(currentDirection.equals(Direction.EAST)){
                currentDirection = Direction.SOUTH;
            }
            else if(currentDirection.equals(Direction.SOUTH)){
                currentDirection = Direction.WEST;
            }
            else{
                currentDirection = Direction.NORTH;
            }
        }
        else if(instruction.equals(Instruction.RIGHT)){
            if(currentDirection.equals(Direction.NORTH)){
                currentDirection = Direction.WEST;
            }
            else if(currentDirection.equals(Direction.EAST)){
                currentDirection = Direction.NORTH;
            }
            else if(currentDirection.equals(Direction.SOUTH)){
                currentDirection = Direction.EAST;
            }
            else{
                currentDirection = Direction.SOUTH;
            }
        }
        else{
            if(currentDirection.equals(Direction.NORTH)){
                this.y = y+1;
            }
            else if(currentDirection.equals(Direction.EAST)){
                this.x = x+1;
            }
            else if(currentDirection.equals(Direction.SOUTH)){
                this.y = y-1;
            }
            else{
                this.x = x-1;
            }
        }
    }
}
