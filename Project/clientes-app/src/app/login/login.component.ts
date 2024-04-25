import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username?:string;
  password?:string;
  loginError?: boolean;
  cadastrando?: boolean;

  constructor(private router: Router){

  }

  onSubmit(){
    console.log(`User: ${this.username}, Pass: ${this.password}`);
    this.router.navigate(['/home']);

  }

  preparandoCadastrar(event: Event){
    event.preventDefault();//metodo q n deixa nada acontecer com a view
    this.cadastrando = true
    console.log(this.cadastrando);

  }

  cancelarCadastrar(){
    this.cadastrando = false;
  }

}
