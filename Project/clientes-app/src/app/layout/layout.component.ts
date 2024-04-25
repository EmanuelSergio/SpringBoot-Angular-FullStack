import { AfterViewInit, Component } from '@angular/core';
import jQuery from 'jquery';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css',
})
export class LayoutComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    (function ($) {
      'use strict';

      // Add active state to sidbar nav links
      var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
      $('#layoutSidenav_nav .sb-sidenav a.nav-link').each(function () {
        if (this instanceof HTMLAnchorElement && this.href === path) {
          $(this).addClass('active');
        }
      });

      // Toggle the side navigation
      $('#sidebarToggle').on('click', function (e) {
        e.preventDefault();
        $('body').toggleClass('sb-sidenav-toggled');
      });
    })(jQuery);
  }
}
