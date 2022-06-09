/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller.states;

import cl.ravenhill.eventual.controller.Controller;
import cl.ravenhill.eventual.exceptions.InvalidStateOperationException;

public class State {
  protected final Controller context;

  public State(Controller context) {
    this.context = context;
  }

  public void toSelectCharacterState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  public void toIdleState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  public void toAttackingState() throws InvalidStateOperationException {
    throw new InvalidStateOperationException();
  }

  public void runAction() throws InvalidStateOperationException {
  }
}
