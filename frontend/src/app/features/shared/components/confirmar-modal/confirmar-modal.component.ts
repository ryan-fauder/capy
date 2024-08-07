import {ChangeDetectionStrategy, Component, Inject} from '@angular/core';
import {TuiButtonModule} from "@taiga-ui/experimental";
import {NgIf} from "@angular/common";
import {POLYMORPHEUS_CONTEXT} from '@tinkoff/ng-polymorpheus';
import {TuiDialogContext} from "@taiga-ui/core";

@Component({
  selector: 'app-confirmar-modal',
  standalone: true,
  imports: [TuiButtonModule, NgIf],
  templateUrl: './confirmar-modal.component.html',
  styleUrl: './confirmar-modal.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ConfirmarModalComponent {
  constructor(
    @Inject(POLYMORPHEUS_CONTEXT) private readonly context: TuiDialogContext<boolean>
  ) {}

  confirm(): void {
    this.context.completeWith(true);
  }

  cancel(): void {
    this.context.completeWith(false);
  }
}
