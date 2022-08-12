class Solution{
    fun judgeCircle(moves: String): Boolean {
        if(moves.length % 2 == 1) return false;
        var xAxisMoves = 0
        var yAxisMoves = 0

        for(move in moves){
            when(move){
                'L' -> xAxisMoves--
                'R' -> xAxisMoves++
                'U' -> yAxisMoves--
                'D' -> yAxisMoves++
            }
        }

        return xAxisMoves == 0 && yAxisMoves == 0
    }
}
