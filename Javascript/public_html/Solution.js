/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function myFunction() {
    
      //get values and create array
      var n = document.getElementById('n').value;
      var array = document.getElementById('array').value;
      array = array.split(" ").map(Number);
      
      if(array.length != n){
          document.getElementById('answer').value = "Invalid input";
          return;
      }
      
      var current;
      var best = 0;
      var bestID = 1;
      
      //decide which starting position is the best
      for(var i = 0; i < n; i++){
            current = cycle(array, i);
            if(current > best){
                best = current;
                bestID = i+1;
            }
        }
        document.getElementById('answer').value = bestID;
      
      
    }
    
    function cycle(arr, startpos){
        
        //copies original arrays values
        var array = Array(arr.length);
        for(var i = 0; i < arr.length; i++){
            array[i] = arr[i];
        }
        console.log(array);
        
        var steps = array.length;
        var finished = 0;

        
        while(steps > 0){
            
            //check if finished drawing
            if(array[startpos] <= 0){
                finished++;
            }
            
            //forward time and progression of the rest
            for(var i = 0; i < array.length; i++){
                array[i]--;
            }
            
            //position of the next to be checked
            startpos++;
            
            //loop to the beginning of array if out of bounds
            if(startpos > array.length-1){
                startpos = 0;
            }
            steps--;
        }
        return finished;
    }