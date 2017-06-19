def mutate_string(string, position, character):

    lst = list(string)
    lst[position] = character

    return "".join(lst)


if __name__ == "__main__":
    string = "abcdef"
    position= 5
    character = "x"
    string_mutated = mutate_string(string, position, character)
    print(string_mutated)