import random


class Card(object):
    values = list(range(2, 16))
    suits = ["Spades", "Hearts", "Diamonds", "Clubs"]
    colors = ["Red", "Black"]
    name = {11: "Jack", 12: "Queen", 13: "King", 14: "Ace", 15: "Joker"}

    def __init__(self, value, suit):
        assert value in Card.values and (
               suit in Card.suits or suit in Card.colors)
        self.value = value
        self.suit = suit

    def __repr__(self):
        if self.value <= 10:
            return str.format("{} of {}", self.value, self.suit)
        elif self.value < 15:
            return str.format("{} of {}", Card.name[self.value], self.suit)
        else:
            return str.format("{} {}", self.suit, Card.name[self.value])

    def __lt__(self, other):
        return self.value < other.value

    def __gt__(self, other):
        return self.value > other.value

    def at_war(self, other):
        return self.value == other.value


class Player(object):
    full_deck = []
    for value in Card.values:
        if value < 15:
            for suit in Card.suits:
                full_deck.append(Card(value, suit))
        else:
            for color in Card.colors:
                full_deck.append(Card(value, color))

    def __init__(self, deck, trash):
        self.deck = deck
        self.trash = trash

    def __repr__(self):
        return "(" + str(self.deck) + ", " + str(self.trash) + ")"

    def won_war(self, other, length=1):
        for i in range(length):
            self.trash.extend([self.deck.pop(), other.deck.pop()])

    def replace_trash(self, shuffle=True):
        self.deck.extend(self.trash)
        self.trash = []
        if shuffle:
            random.shuffle(self.deck)

    def at_war(self, other):
        return Card.at_war(self.deck[-1], other.deck[-1])

    def total_cards(self):
        return len(self.deck) + len(self.trash)

    def war_adjust(self):
        if len(self.deck) < 5:
            self.replace_trash(shuffle=False)

    # def war_adjusted(self):
    #    if len(self.deck) >= 5:
    #        return 1
    #    elif self.total_cards() >= 5:
    #        return 0
    #    else:
    #        return -1

    def war(self, other):
        self.war1(other)

    def war1(self, other, recursions=0):
        self.war_adjust()
        other.war_adjust()

        if recursions > 14:
            #print("Recursion!")
            self.replace_trash()
            other.replace_trash()

        n = min(5, len(self.deck), len(other.deck))
        #print(self.deck[-n], other.deck[-n])
        if self.deck[-n] > other.deck[-n]:
            self.won_war(other, length=n)
            return True
        elif self.deck[-n] < other.deck[-n]:
            other.won_war(self, length=n)
            return False
        else:
            winner_trash = []
            for i in range(n - 1):
                winner_trash.extend([self.deck.pop(), other.deck.pop()])
            if self.war1(other, recursions+1):
                self.trash.extend(winner_trash)
                return True
            else:
                other.trash.extend(winner_trash)
                return False
