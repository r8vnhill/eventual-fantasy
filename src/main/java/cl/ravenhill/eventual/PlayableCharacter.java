/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual;

import java.util.Objects;

/**
 * A character that can be controlled by the player.
 */
public class PlayableCharacter {

  private final String name;

  /**
   * Creates a new playable character.
   *
   * @param name the name of the character
   */
  public PlayableCharacter(String name) {
    this.name = name;
  }

  /**
   * Checks if this object is equal to another object.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PlayableCharacter other) {
      return Objects.equals(name, other.name);
    }
    return false;
  }

  /**
   * Returns a hash code for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(PlayableCharacter.class, name);
  }

  /**
   * Returns a string representation of the object.
   */
  @Override
  public String toString() {
    return "PlayableCharacter{}";
  }
}
