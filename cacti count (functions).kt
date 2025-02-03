package com.ggwhiting.cacticount


fun isValidString(debug: Boolean, str: Array<Int>): Boolean {
// checking for anything other than a 1 or a 0
    for(intValue in str){
        if(debug){
            println("[DEBUG] intValue == " + intValue)
        }
        if(intValue != 0 && intValue != 1){
            return false
        }
    }
    return true
}

fun countCacti(debug: Boolean, str: Array<Int>): Int {
    var cacticount = 0
    var totalCacti = 0

    for(intValue in str){
        if(debug){
            println("[DEBUG] intValue == " + intValue)
        }

        if(intValue == 1){ 
            cacticount++
            if(cacticount > 3){
                return -1;
            }
        } 
        else {
            totalCacti += cacticount 
            cacticount = 0 
        }
    }   
    return totalCacti
}

public fun run(debug: Boolean, str: Array<Int>): Unit {
    var answer = 0
    val elapsedTime = System.nanoTime()

    if(!isValidString(debug, str)) {
        println("[ERROR]\n[INFO] Invalid bit array.")   
        println("[INFO] Exiting")
        return
    }

    println("[INFO] Valid bit array.")

    answer = countCacti(debug, str)

    if(answer == -1){
        println("[ERROR]\n[INFO] The number of cacti is greater than 3 - Invalid format")
        return
    }

    println("Output: " + answer)

    println("Elapsed time:" + (System.nanoTime() - elapsedTime) + "ns")
}

fun main(args: Array<String>) {
    val cacti = arrayOf(0,1,0,0,1,1,1,0,0,1,1)
    val badFormat1 = arrayOf(0,1,1,1,0,2,0,1,0)
    val badFormat2 = arrayOf(0,1,0,0,1,1,1,1,0,1,1)
    var debugging = false


    println("App: Cacti Count")
    println("")

// enable debugging?
    print("Would you like debug info enabled? (y/n): ")
    var enableDebugging = readLine()?.get(0)

    if(enableDebugging == 'y' || enableDebugging == 'Y'){
        debugging = true
    }else {
        debugging = false
    }

    println("")

// test 1
    println("[GOOD TEST]")
    println("Running valid bit array: ")
    run(debugging, cacti)

    println("")
    
// test 2
    println("[BAD TEST]")
    println("Runnin bad bit array:")
    run(debugging, badFormat1)

    println("")
    
// test 2
    println("[BAD TEST]")
    println("Runnin bad bit array:")
    run(debugging, badFormat1)

    println("End of line.")
}