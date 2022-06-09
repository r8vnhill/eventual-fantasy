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

public class AttackingState extends SelectCharacterState {
  public AttackingState(Controller context) throws InvalidStateOperationException {
    super(context);
    context.doAttack();
  }

  @Override
  public void runAction() throws InvalidStateOperationException {
    context.doAttack();
  }
}
