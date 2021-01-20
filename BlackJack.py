import random

suits = ('Hearts', 'Diamonds', 'Spades', 'Clubs')

ranks = ('Two', 'Three', 'Four', 'Five', 'Six', 'Seven',
         'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King', 'Ace')

values = {'Two': 2, 'Three': 3, 'Four': 4, 'Five': 5, 'Six': 6, 'Seven': 7, 'Eight': 8, 'Nine': 9, 'Ten': 10,
          'Jack': 10, 'Queen': 10, 'King': 10, 'Ace': 11}

playing = True


class Card:

    def __init__(self, suit, rank):
        self.suit = suit
        self.rank = rank

    def __str__(self):
        return self.rank + ' of ' + self.suit


class Deck:

    def __init__(self):

        self.deck = []  # start with an empty list

        for suit in suits:
            for rank in ranks:
                self.deck.append(Card(suit, rank))

    def __str__(self):

        card_list = ''

        for card in self.deck:
            card_list += '\n' + Card.__str__(card)

        return card_list

    def shuffle(self):
        random.shuffle(self.deck)

    def deal(self):
        return self.deck.pop()


class Hand:

    def __init__(self):

        self.cards = []  # start with an empty list as we did in the Deck class
        self.value = 0  # start with zero value
        self.aces = 0  # add an attribute to keep track of aces

    def add_card(self, card):

        self.cards.append(card)
        self.value += values[card.rank]

        if card.rank == 'Ace':
            self.aces += 1

    def adjust_for_ace(self):

        while self.value > 21 and (self.aces > 0):
            self.value -= 10
            self.aces -= 1


class Chips:

    def __init__(self):
        self.total = 100  # This can be set to a default value or supplied by a user input
        self.bet = 0

    def win_bet(self):
        self.total += self.bet

    def lose_bet(self):
        self.total -= self.bet


def take_bet(chips):
    while True:
        try:
            chips.bet = int(input("Enter a bet amount as an integer. "))

            if chips.bet > chips.total:
                print("Bet must not exceed total chips!")

            else:
                break
        except:
            print("Not an integer, try again.")


def hit(deck, hand):
    hand.add_card(deck.deal())
    hand.adjust_for_ace()


def hit_or_stand(deck, hand):
    global playing  # to control an upcoming while loop

    while True:

        x = int(
            input("Would you like to hit or stand? Press 1 to hit and 2 to stand. "))

        if x == 1:
            hit(deck, hand)

        elif x == 2:
            print("Player decides to stand\n")
            playing = False

        else:
            print("Invalid input, try again\n")
            continue

        break


def show_some(player, dealer):
    print("Dealer hand:")
    print("<Hidden Card>")

    for i in range(len(dealer.cards) - 1):
        print(dealer.cards[i + 1])

    print("\nPlayer hand:")

    for i in range(len(player.cards)):
        print(player.cards[i])

    print('\n')


def show_all(player, dealer):
    print("Dealer hand:")

    for i in range(len(dealer.cards)):
        print(dealer.cards[i])

    print("\nPlayer hand:")

    for i in range(len(player.cards)):
        print(player.cards[i])

    print('\n')


def player_busts(chips):
    print("Player busts!")
    chips.lose_bet()


def player_wins(chips):
    print("Player wins!")
    chips.win_bet()


def dealer_busts(chips):
    print("Dealer busts!")
    chips.win_bet()


def dealer_wins(chips):
    print("Dealer wins!")
    chips.lose_bet()


def push():
    print("Tie! Its a push!")


while True:
    # Print an opening statement
    print("Welcome to BlackJack!")
    print("\nRules are as follows: \n1. Each player is dealt two cards." +
          "\n2. The player will be shown all their cards while the dealer will show all cards except the first." +
          "\n3. The player starts with $100 of betting money and will play until they run out." +
          "\n4. The goal of the game is to come as close to hand value 21 as possible without going over." +
          "\n5. The game will ask the player if they want to hit or stand." +
          "\n6. Hit means to draw another card from the deck and stand means to compare hand values to determine "
          "winner." +
          "\n7. The player may hit as many times as they wish but will lose if they go over hand value 21."
          "\n8. The card values are determined by the number on the cards. " +
          "Face cards are value 10 and Aces are either 1 or 11 and will be automatically determined for the player.")
    print("\nGood luck and may the odds be ever in your favor!\n")

    # Create & shuffle the deck, deal two cards to each player

    game_Deck = Deck()
    game_Deck.shuffle()

    player = Hand()
    dealer = Hand()

    for i in range(2):
        player.add_card(game_Deck.deal())
        dealer.add_card(game_Deck.deal())

    # Set up the Player's chips

    chips = Chips()

    # Prompt the Player for their bet

    take_bet(chips)

    # Show cards (but keep one dealer card hidden)

    show_some(player, dealer)

    playing = True

    while playing:  # recall this variable from our hit_or_stand function

        # Prompt for Player to Hit or Stand

        hit_or_stand(game_Deck, player)

        # Show cards (but keep one dealer card hidden)

        show_some(player, dealer)

        # If player's hand exceeds 21, run player_busts() and break out of loop

        if player.value > 21:
            player_busts(chips)
            break

    # If Player hasn't busted, play Dealer's hand until Dealer reaches 17

    if player.value <= 21:

        while dealer.value <= 17:
            hit(game_Deck, dealer)

        # Show all cards

        show_all(player, dealer)

        # Run different winning scenarios

        if dealer.value > 21:
            dealer_busts(chips)

        elif dealer.value > player.value:
            dealer_wins(chips)

        elif player.value > dealer.value:
            player_wins(chips)

        else:
            push()

    # Inform Player of their chips total

    print(f'Your chips total is now {chips.total}')

    # Ask to play again

    x = int(
        input("Would you like to play again? Press 1 to play again and 2 to end. "))

    if x == 1:
        continue

    if x == 2:
        print("Thank you for playing")
        break
