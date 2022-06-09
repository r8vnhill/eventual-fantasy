/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller;

import cl.ravenhill.eventual.GameCharacter;
import cl.ravenhill.eventual.InputManager;
import cl.ravenhill.eventual.controller.states.IdleState;
import cl.ravenhill.eventual.controller.states.State;
import cl.ravenhill.eventual.exceptions.InvalidStateOperationException;
import java.util.List;
import java.util.Scanner;

/**
 * The game controller.
 *
 * <p>This class is responsible for the game logic, manages the game loop and state.
 * This class implements multiple handlers for the game events.
 */
public class Controller {
  private final GameCharacter player = new GameCharacter("Player");
  private final List<GameCharacter> enemies =
      List.of(new GameCharacter("Enemy 1"), new GameCharacter("Enemy 2"), new GameCharacter("Enemy 3"));
  private State state = new IdleState(this);
  private GameCharacter selectedCharacter;
  private InputHandler inputHandler = new InputHandler(this);
  private InputManager inputManager = new InputManager();

  public Controller() {
    inputManager.addInputPromptListener(inputHandler);
  }

  public static void main(String[] args) throws InvalidStateOperationException {
    Controller controller = new Controller();
    controller.startBattle();
  }

  /**
   * Creates a new playable character.
   */
  public GameCharacter createPlayableCharacter(String name) {
    return new GameCharacter(name);
  }

  public void startBattle() throws InvalidStateOperationException {
    state.toAttackingState();
    inputManager.promptForInput();
  }

  public void setState(State state) {
    this.state = state;
  }

  public void promptCharacterSelection() {
    System.out.println("Select a character to attack");
    for (int i = 0; i < enemies.size(); i++) {
      System.out.println(i + ") " + enemies.get(i).getName());
    }
    Scanner scanner = new Scanner(System.in);
    selectedCharacter = enemies.get(scanner.nextInt());
    inputManager.processInput();
  }

  public void doAttack() throws InvalidStateOperationException {
    System.out.println(player.getName() + " attacks " + selectedCharacter.getName());
  }

  public void onSelectedCharacterChanged(GameCharacter selectedCharacter) {
    System.out.println(player.getName() + "attacks " + selectedCharacter.getName());
  }

  public void runContextAction() {
    try {
      state.runAction();
    } catch (InvalidStateOperationException e) {
      System.err.println("Invalid operation in current state");
    }
  }
}
