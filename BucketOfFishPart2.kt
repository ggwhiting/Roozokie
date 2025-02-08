package com.ggwhiting.bucketsoffish


class Fisherman{
    val bucketMap = HashMap<Int,Int>()

    public fun sort(bc: ArrayList<Int>, fs: ArrayList<Int>): ArrayList<Int> {
// set the hashmap bucketMap default values
        for(bucket in bc){
            this.bucketMap.put(bucket,0)
        }

// tally up fishes to bucket size
        for(bucket in bc){
            for(fish in fs){
                if(fish <= bucket){
                    var fishAmount: Int? = this.bucketMap.get(bucket)

                    if(fishAmount != null){ fishAmount += 1 }

                    println(fishAmount as Int)

                    this.bucketMap.put(bucket, fishAmount as Int)

                    fs.remove(fish)
                }
            }
        }

// create arraylist from answer 
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

    println(">> answer = " + answer.toString())
}
