def swap_case(s):
    s_new = ''
    for c in s:
        if c.isupper():
            s_new += c.lower()
        else:
            s_new  += c.upper()
    return s_new

if __name__ == '__main__':
    s = "TeSt"
    s_new = swap_case(s)

    s_new_2 = s.swapcase()


    print(s_new_2)