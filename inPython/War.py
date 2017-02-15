from Card import Card, Player
import random

deck = Player.full_deck

random.shuffle(deck)
player1 = Player(deck[:27], [])
player2 = Player(deck[27:], [])
# print(player1.total_cards(), player2.total_cards())

while player1.total_cards() < 54 and player2.total_cards() < 54:
    #print(player1.deck[-1], player2.deck[-1])
    if player1.deck and player2.deck:
        if player1.deck[-1] > player2.deck[-1]:
            player1.won_war(player2)
        elif player2.deck[-1] > player1.deck[-1]:
            player2.won_war(player1)
        elif Player.at_war(player1, player2):
            player1.war(player2)

    # checks if the decks are empty
    # if they are, inserts the trash into them
    if not player1.deck:
        player1.replace_trash()
    if not player2.deck:
        player2.replace_trash()
    # print(player1.total_cards(), player2.total_cards())

if player1.total_cards() == 54:
    print("Player 1 won")
elif player2.total_cards() == 54:
    print("Player 2 won")
else:
    print("A fucking error")
