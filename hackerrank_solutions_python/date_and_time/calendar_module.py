# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 22:50:42 2016

@author: Zhou Qiao

Input:
    08 05 2015

Output: 
    WEDNESDAY
"""




(m,d,y) = tuple(map(int, input().split()))

using_calendar = True

if using_calendar:
    import calendar
    a = calendar.weekday(y, m, d)
    print(calendar.day_name[a].upper())
    
    '''
    Another solution: 
    print(calendar.day_name[calendar.weekday(y, m, d)].upper())    
    '''
else: 
    import datetime
    a = datetime.datetime(y,m,d)
    print(a.strftime("%A").upper())
    
