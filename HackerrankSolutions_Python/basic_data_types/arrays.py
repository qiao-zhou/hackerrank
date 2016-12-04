# -*- coding: utf-8 -*-
"""
Created on Mon Oct 17 22:53:12 2016

@author: Zhou Qiao
"""

import numpy as np
numbers = input()
reversed_num_strs = numbers.split(" ")[::-1]

#print np.array(reversed_num_strs).astype(np.float)
print(np.array(reversed_num_strs,np.float))




#print np.array(raw_input().split(),float)[::-1]

#print np.flipud(np.array(raw_input().split(),float))