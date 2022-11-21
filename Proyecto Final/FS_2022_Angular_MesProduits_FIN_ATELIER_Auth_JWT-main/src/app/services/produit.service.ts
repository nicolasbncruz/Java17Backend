import { Injectable } from '@angular/core';
import { Categorie } from '../model/categorie.model';
import { Produit } from '../model/produit.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { CategorieWrapper } from '../model/catgorieWrapped.model';
import { AuthService } from './auth.service';
import { apiURL } from '../config';

const httpOptions = {
headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};


@Injectable({
  providedIn: 'root'
})
export class ProduitService {


  apiURLCat: string = 'http://localhost:8080/produits/cat';

  produits! : Produit[]; //un tableau de produits
  //categories : Categorie[];


  constructor(private http : HttpClient,
              private authService : AuthService) {

    /* this.categories = [
      {idCat : 1, nomCat : "PC"},
      {idCat : 2, nomCat : "Imprimante"}
    ]; */
  /*  this.produits = [{idProduit : 1, nomProduit : "PC Asus", prixProduit : 3000.600, dateCreation : new Date("01/14/2011"),
                      categorie : {idCat : 1, nomCat : "PC"} },
                     {idProduit : 2, nomProduit : "Imprimante Epson", prixProduit : 450, dateCreation : new Date("12/17/2010"),
                    categorie :  {idCat : 2, nomCat : "Imprimante"}},
                     {idProduit : 3, nomProduit :"Tablette Samsung", prixProduit : 900.123, dateCreation : new Date("02/20/2020"),
                     categorie : {idCat : 1, nomCat : "PC"}}
                    ];
                    */

  }

  listeProduit(): Observable<Produit[]>{
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt})
return this.http.get<Produit[]>(apiURL+"/all",{headers:httpHeaders});

    }

    ajouterProduit( prod: Produit):Observable<Produit>{
      let jwt = this.authService.getToken();
      jwt = "Bearer "+jwt;
      let httpHeaders = new HttpHeaders({"Authorization":jwt})
        return this.http.post<Produit>(apiURL, prod, {headers:httpHeaders});
    }

    subirFoto(archivo: File, idProduit: any): Observable<HttpEvent<{}>> {
      let formData = new FormData();
      formData.append("archivo", archivo);
      formData.append("id", idProduit);
      const req = new HttpRequest('POST', `${apiURL}/upload`, formData, {
      reportProgress: true
    });
    return this.http.request(req);
  }

   
  supprimerProduit(id : number) {
        const url = `${apiURL}/${id}`;
        let jwt = this.authService.getToken();
        jwt = "Bearer "+jwt;
        let httpHeaders = new HttpHeaders({"Authorization":jwt})
          return this.http.delete(url,  {headers:httpHeaders});
        }

       consulterProduit(id: number): Observable<Produit> {
          const url = `${apiURL}/${id}`;
          let jwt = this.authService.getToken();
          jwt = "Bearer "+jwt;
          let httpHeaders = new HttpHeaders({"Authorization":jwt})
            return this.http.get<Produit>(url,{headers:httpHeaders});
          }

      updateProduit(prod :Produit) : Observable<Produit>    {
          let jwt = this.authService.getToken();
          jwt = "Bearer "+jwt;
          let httpHeaders = new HttpHeaders({"Authorization":jwt})
            return this.http.put<Produit>(apiURL, prod, {headers:httpHeaders});
          }



       listeCategories():Observable<CategorieWrapper>{
        let jwt = this.authService.getToken();
        jwt = "Bearer "+jwt;
        let httpHeaders = new HttpHeaders({"Authorization":jwt})
        return  this.http.get<CategorieWrapper>(this.apiURLCat,{headers:httpHeaders});

            }

       rechercherParCategorie(idCat: number): Observable<Produit[]> {
          const url = `${apiURL}/prodscat/${idCat}`;
          return this.http.get<Produit[]>(url);
         }

  rechercherParNom(nom: string):Observable< Produit[]> {
    const url = `${apiURL}/prodsByName/${nom}`;
    return this.http.get<Produit[]>(url);
    }

    ajouterCategorie( cat: Categorie):Observable<Categorie>{
      return this.http.post<Categorie>(this.apiURLCat, cat, httpOptions);
      }



}
