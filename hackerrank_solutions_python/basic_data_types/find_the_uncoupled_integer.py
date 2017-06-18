# -*- coding: utf-8 -*-
"""
Created on Sun Sep 25 12:22:02 2016

Find the uncoupled integer

@author: Zhou Qiao
"""


# wait for user inputs
my_string = input()
# get number of numbers to be processed
num_numbers = len(my_string)
# use a dict object to store the key value pairs, 
# where key is the number and val is the number of occurence 
my_dict = dict()

# for each number
for i in range(num_numbers):
    number = my_string[i]
    # if it is in the dict, increment the count by 1
    if my_dict.has_key(number):
        my_dict[number] += 1
    else:#if it is not in the dict, add to dict and initialize the count to 1
        my_dict[number] = 1

#get the list of keys and values as two lists 
key_set = my_dict.keys()
val_set = my_dict.values()
#visit each key value pairs in the dict and output the Key whose value is 
#odd number (i.e., not divisorble by 2)
for i in range(len(key_set)):
    key = key_set[i]
    val = val_set[i]
    if val % 2 == 1:
        print(key)
        break;