/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller;

import cl.ravenhill.eventual.controller.states.GameState;
import cl.ravenhill.eventual.controller.states.RunningState;
import cl.ravenhill.eventual.exceptions.UnsupportedStateOperationException;
import cl.ravenhill.eventual.model.GameCharacter;
import cl.ravenhill.eventual.ui.InputManager;
import java.util.List;
import java.util.Scanner;

public class GameController {
  private final GameCharacter player = createCharacter("player");
  private final List<GameCharacter> enemies =
      List.of(createCharacter("enemy1"), createCharacter("enemy2"),
              createCharacter("enemy3"));
  private GameState state = new RunningState(this);
  private GameCharacter selectedTarget;
  private final InputManager inputManager = new InputManager();

  public GameController() {
    var inputListener = new InputListener(this);
    inputManager.addInputPromptListener(inputListener);
  }


  public static void main(String[] args) throws UnsupportedStateOperationException {
    GameController controller = new GameController();
    controller.battle();
  }

  public GameCharacter createCharacter(String name) {
    return new GameCharacter(name);
  }

  public void battle() throws UnsupportedStateOperationException {
    state.toSelectingTargetState(); // !
    inputManager.promptForInput();
  }

  public void promptSelection() throws UnsupportedStateOperationException {
    System.out.println("Select a character to attack");
    for (int i = 0; i < enemies.size(); i++) {
      System.out.println(i + ") " + enemies.get(i).getName());
    }
    Scanner scanner = new Scanner(System.in);
    selectedTarget = enemies.get(scanner.nextInt());
    inputManager.processInput();
  }

  public void setState(GameState state) {
    this.state = state;
  }

  public void doAttack() throws UnsupportedStateOperationException {
    player.attack(selectedTarget);
    state.toRunningState();
  }

  public void doContextAction() throws UnsupportedStateOperationException {
    state.doAction();
  }
}
