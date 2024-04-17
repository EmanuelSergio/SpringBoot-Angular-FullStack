import { Component, Input, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from "../../clientes.service"
import { response } from 'express';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css',
})
export class ClientesFormComponent implements OnInit {
  cliente: Cliente;
  success: boolean = false;
  errors?: String[];

  constructor(private service: ClientesService, private router: Router) {
    this.cliente = new Cliente();
  }

  ngOnInit(): void {}

  onSubmit() {
    this.service.salvar(this.cliente).subscribe(
      (response) => {
        console.log(response);
        this.success = true;
        this.errors = [];
        this.cliente = response;
      },
      (errorResponse) => {
        this.errors = errorResponse.error.errors;
        this.success = false;
      }
    );
  }

  voltarParaListagem(){
    this.router.navigate(['/clientes-list']);
  }



}
