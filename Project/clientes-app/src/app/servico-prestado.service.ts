import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ServicoPrestado } from './servico-prestado/servicoPrestado';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { ServicoPrestadoBusca } from './servico-prestado/servico-prestado-lista/servicoPrestadoBusca';

@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {

  apiURL: string = environment.apiURLBase + "/api/servicos-prestados"

  constructor(private http: HttpClient) { }

  salvar(servicoPrestado: ServicoPrestado): Observable<ServicoPrestado>{
    return this.http.post<ServicoPrestado>(this.apiURL ,servicoPrestado);
  }

  buscar(nome:string, mes:number): Observable<ServicoPrestadoBusca[]> {
    const httpParams = new HttpParams().set("nome",nome).set("mes",mes ? mes.toString() : '' );


    console.log(httpParams);

    const url = this.apiURL + "?" + httpParams.toString();
    console.log(url);
    return this.http.get<any>(url);
  }

}
