package com.ggwhiting.bucketsoffish


class Fisherman{
    val bucketMap = HashMap<Int,Int>()

    public fun sort(bc: ArrayList<Int>, fs: ArrayList<Int>): ArrayList<Int> {
// ...
        var bucketSize = bc.size - 1
        var bucketReversed = bc.reversed()
        var fishCount = 0

// set the hashmap bucketMap default values
        for(bucket in bucketReversed){
            var fishID = fs.size - 1
            println(">> --- bucketID: "+bucket + " ---")
            this.bucketMap.put(bucket, fishCount)

            while(fishID >= 0){
                println(">> fishID: "+fs.get(fishID))

                if(fs.get(fishID) <= bucket){
                    fishCount++
                    fs.removeAt(fishID)
                }

                this.bucketMap.put(bucket, fishCount)
                fishID--
            }
            
            fishCount = 0
        }

// tally up fishes to bucket size// create arraylist from answer 
        val answer: ArrayList<Int> = arrayListOf()

        for(amount in this.bucketMap.values){
            answer.add(amount)
        }

        return answer
    }
}


fun main(args: Array<String>) {
    val bucketCapacity: ArrayList<Int> = arrayListOf(7,5,2)
    val fishSize: ArrayList<Int> = arrayListOf(4,7,4,1,1,69)
    val fisherman = Fisherman()
    
    val answer = fisherman.sort(bucketCapacity, fishSize)

    println(">> answer = " + answer.toString().reversed())
}