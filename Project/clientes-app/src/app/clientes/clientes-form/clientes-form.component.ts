import { Component, Input, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from "../../clientes.service"
import { response } from 'express';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css',
})
export class ClientesFormComponent implements OnInit {
  cliente: Cliente;
  success: boolean = false;
  errors?: String[];
  id?: number;

  constructor(
    private service: ClientesService,
    private router: Router,
    private activatedRoute : ActivatedRoute) {

    this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activatedRoute.params
    params.subscribe(urlParams => {
      this.id = urlParams['id']
      if (this.id) {
        this.service
        .getClienteById(this.id)
        .subscribe(
          response => this.cliente = response,
          errorResponse => this.cliente = new Cliente())
      }
    })


  }

  onSubmit() {

    if(this.id){

      this.service.atualizar(this.cliente).subscribe(response => {
        this.success = true;
        this.errors = []
      }, errorResponse => {
        this.errors = ['Erro ao atualizar o cliente']
      })

    }else{

    }

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
    this.router.navigate(['/clientes/lista']);
  }



}
