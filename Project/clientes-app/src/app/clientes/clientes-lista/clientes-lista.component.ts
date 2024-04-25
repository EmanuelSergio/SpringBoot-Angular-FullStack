import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClientesService } from '../../clientes.service';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrl: './clientes-lista.component.css',
})
export class ClientesListaComponent implements OnInit {
  clientes: Cliente[] = [];
  clienteSelecionado!: Cliente;
  mensagemSucesso?: String;
  mensagemErro?: String;

  constructor(private service: ClientesService, private router: Router) {}

  ngOnInit(): void {
    this.service.getClientes().subscribe((resposta) => {
      this.clientes = resposta;
    });
  }

  novoCadastro() {
    this.router.navigate(['/clientes/form']);
  }

  preparaDelecao(cliente: Cliente) {
    this.clienteSelecionado = cliente;
  }

  deletarCliente() {
    this.service.deletar(this.clienteSelecionado)
    .subscribe(response => {this.mensagemSucesso = "Cliente deletado com sucesso"; this.ngOnInit()},
               erro => {this.mensagemErro = "Ocorreu um erro ao deletar o cliente"});
  }
}
