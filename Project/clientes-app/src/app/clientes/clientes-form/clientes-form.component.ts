import { Component, Input, OnInit } from '@angular/core';
import { Cliente } from '../cliente';


@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css',
})
export class ClientesFormComponent implements OnInit {


  cliente: Cliente;
  nome: string = 'fulano'

  constructor(){
    this.cliente = new Cliente();
    this.cliente.nome = "eeee"
  }


  ngOnInit(): void {}

  clicar(){
    console.log("apertei");

  }



}
