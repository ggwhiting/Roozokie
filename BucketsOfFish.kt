package com.ggwhiting.bucketsoffish


class Fisherman{
    private var bucketCapacity: ArrayList<Int> = arrayListOf()
    private var fishSize: MutableList<Int> = mutableListOf()
    private val bucketMap = HashMap<Int, Int>()

    public fun setDetails(bc: ArrayList<Int>, fs: ArrayList<Int>){
        this.bucketCapacity = bc
        this.fishSize.addAll(fs)
    }

    public fun addToBucket(bucketID: Int){
        if(!this.bucketMap.containsKey(bucketID)){
            this.bucketMap.put(bucketID, 1)
        }else{
            var currentValue: Int = bucketMap?.get(bucketID) as Int
            currentValue++
            this.bucketMap.put(bucketID, currentValue)
        }

        println("[debug] bucketMap = " + this.bucketMap.toString())
    }

    public fun calculate(): Array<Int> {
        var counter = this.bucketCapacity.size - 1
        var position = 0
        var output: ArrayList<Int> = arrayListOf()
        var fishesInBucket: Int = 0

        while(counter >= 0){
            val currentBucket = this.bucketCapacity.get(counter)
            fishesInBucket = 0

            for(fish in this.fishSize){
                println("[debug] bucket = " + currentBucket + " - fish   = " + fish.toString() + " - bucket = " + fishesInBucket.toString())
                if(fish <= currentBucket){
                    println("[update]" + fish.toString() + " <= " + currentBucket.toString())
                    this.addToBucket(currentBucket)
                    this.fishSize.remove(fish)
                }
            }
            counter--
        }


        println("[debug] output = " + output.toString())


        return arrayOf()
    }
}


fun main(args: Array<String>) {
    val bucketCapacity: ArrayList<Int> = arrayListOf(7,5,2)
    val fishSize: ArrayList<Int> = arrayListOf(4,7,4,1,1,69)
    val fisherman = Fisherman()
    fisherman.setDetails(bucketCapacity, fishSize)
    val answer: Array<Int> = fisherman.calculate()
    for(value in answer){
        print(value)
    }
    println("\nEnd of Line")
}