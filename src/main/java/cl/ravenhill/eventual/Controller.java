/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual;

/**
 * The game controller.
 *
 * <p>This class is responsible for the game logic, manages the game loop and state.
 * This class implements multiple handlers for the game events.
 */
public class Controller {

  /**
   * Creates a new playable character.
   */
  public PlayableCharacter createPlayableCharacter(String name) {
    return new PlayableCharacter(name);
  }
}
