import {Inject, Injectable} from '@angular/core';
import {TuiAlertService, TuiNotificationT} from "@taiga-ui/core";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  constructor(@Inject(TuiAlertService) private readonly alerts: TuiAlertService) {}

  showNotification(message: string, type: TuiNotificationT): void {
    this.alerts
      .open(message, {status: type, autoClose: 3000})
      .subscribe();
  }
}
