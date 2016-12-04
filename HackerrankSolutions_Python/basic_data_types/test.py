# -*- coding: utf-8 -*-
"""
Created on Sun Sep 25 22:50:10 2016

@author: Zhou Qiao
"""

from scipy.stats import norm
import pandas as pd


norm.ppf(0.99)

norm.ppf(1-0.99)



df = pd.read_csv("volume.csv",index_col=0)[["win_vol_measure","los_vol_measure"]]
df.set_index(pd.to_datetime(df.index, format="%d-%m-%Y",infer_datetime_format=True),inplace=True)
df.set_index(pd.to_datetime([str(idx.year)+'-'+str(idx.month) for idx in df.index], 
                                  format="%Y-%m",infer_datetime_format=True),inplace=True)
                                  
df.dropna(axis=0, inplace=True)


df.plot()


