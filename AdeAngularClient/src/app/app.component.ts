import { Component } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

/** Si auto reload marche plus Ubuntu
 * echo "fs.inotify.max_user_watches=524288" | sudo tee -a /etc/sysctl.conf
   sudo sysctl -p
 */
export class AppComponent {

  title: string;

  constructor(private _route: ActivatedRoute,
              private _router: Router) {
    this.title = 'Spring Boot - Angular Application pour ADE';
  }

}
