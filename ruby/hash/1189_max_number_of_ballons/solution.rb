def max_number_of_balloons(text)
    count = Hash.new(0)
    
    text.each_char {|c|
       count[c] = 1 + count[c]
    }
    
  
    nums = Array[count['a'], count['b'], count['n'], count['l']/2, count['o']/2]
    return nums.min
    
    
end

puts max_number_of_balloons("nlaebolko")
