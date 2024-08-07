import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {devEnvironment} from "../../../../environments/environment.development";
import { HttpClient } from '@angular/common/http';
import {ProdutoRequest, ProdutoResponse} from "./interfaces/produtos.interface";

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  private apiUrl = `${devEnvironment.apiUrl}/produtos`; // URL da API

  constructor(private http: HttpClient) {}

  public create(produto: ProdutoRequest): Observable<ProdutoResponse> {
    return this.http.post<ProdutoResponse>(`${this.apiUrl}`, produto);
  }

  public list(): Observable<ProdutoResponse[]> {
    return this.http.get<ProdutoResponse[]>(`${this.apiUrl}`);
  }

  public get(id: number): Observable<ProdutoResponse> {
    return this.http.get<ProdutoResponse>(`${this.apiUrl}/${id}`);
  }

  public update(id: number, produto: ProdutoRequest): Observable<ProdutoResponse> {
    return this.http.put<ProdutoResponse>(`${this.apiUrl}/${id}`, produto);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
