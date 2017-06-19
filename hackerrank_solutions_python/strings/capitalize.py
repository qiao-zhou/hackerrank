def capitalize_alternative(string):
    '''
    capitalize each word in a string
    :param string:
    :return:
    '''

    words = string.split(" ")
    return " ".join(list(map(lambda x: x.capitalize(), words)))

def capitalize(string):
    '''
    capitalize each word in a string
    :param string:
    :return:
    '''

    for x in string[:].split():
        string = string.replace(x, x.capitalize())
    return string

if __name__ == '__main__':
    string = "hello world how are you"
    string = "q w e r t y u i o p a s d f g h j  k l z x c v b n m Q W E R T Y U I O P A S D F G H J  K L Z X C V B N M"
    print(string)
    print(capitalize_alternative(string))
    print(capitalize(string))
