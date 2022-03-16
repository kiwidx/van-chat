package com.kiwi.chat

class CheckNum (val numSign: String){
    enum class NumSignState{
        OK, TOOSHORT, TOOLONG, ERROR
    }
    var state = NumSignState.ERROR
    //MutableList can be modified
    val checkList = ('a'..'z').toMutableList() + ('A'..'Z').toMutableList() + ('0'..'9').toMutableList()
    fun userId(): NumSignState{
        when {
            //signup username 4~20 words
            numSign.length < 4 -> state = NumSignState.TOOSHORT
            numSign.length > 20 -> state = NumSignState.TOOLONG
            else -> state = NumSignState.OK
        }
        //check input numsign in ckecklist if yes -> true  or not -> false and state is ERROR
        for(num in numSign){
            if(!checkList.contains(num)){
                 state = NumSignState.ERROR
            }
        }
        return state
    }

    fun userPass(): NumSignState{
        when{
            numSign.length < 6 -> state = NumSignState.TOOSHORT
            numSign.length > 20 -> state = NumSignState.TOOLONG
            else -> state = NumSignState.OK
        }
        for(num in numSign){
            if (!checkList.contains(num)){
                state = NumSignState.ERROR
            }
        }
        return state
    }
}