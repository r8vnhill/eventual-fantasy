/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.model;

import org.jetbrains.annotations.NotNull;


public class GameCharacter {
  private final String name;

  public GameCharacter(String name) {
    this.name = name;
  }

  public void attack(@NotNull GameCharacter target) {
    System.out.println(name + " attacks " + target.name);
  }

  public String getName() {
    return name;
  }
}
