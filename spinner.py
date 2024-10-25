import turtle

# Setup the turtle screen
screen = turtle.Screen()
screen.bgcolor("lightblue")
screen.title("Fidget Spinner Game")

# Create the turtle for the fidget spinner
spinner = turtle.Turtle()
spinner.shape("circle")
spinner.color("red")
spinner.shapesize(stretch_wid=1, stretch_len=4)  # Making the spinner elongated
spinner.speed(0)

# Variable to keep track of the spin speed
spin_speed = 0

# Function to increase the spin speed
def spin():
    global spin_speed
    spin_speed += 10

# Function to update the spinner's rotation
def animate():
    global spin_speed
    spinner.right(spin_speed)  # Rotate the spinner
    spin_speed *= 0.97  # Gradually slow down the spin
    screen.ontimer(animate, 20)  # Repeat the animation every 20ms

# Set up the screen click event
screen.onclick(lambda x, y: spin())

# Start the spinner animation
animate()

# Run the turtle graphics loop
screen.mainloop()
