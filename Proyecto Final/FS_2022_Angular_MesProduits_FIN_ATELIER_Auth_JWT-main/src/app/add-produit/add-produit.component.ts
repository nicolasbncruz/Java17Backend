import { HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../model/categorie.model';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html'
})
export class AddProduitComponent implements OnInit {

  private fotoSeleccionada: File;
  progreso: number = 0;
  newProduit = new Produit();
  categories! : Categorie[];
  newIdCat! : number;
  newCategorie! : Categorie;


  constructor(private produitService: ProduitService,
              private router : Router) { }

  ngOnInit(): void {

    this.produitService.listeCategories().
          subscribe(cats => {this.categories = cats._embedded.categories;
            console.log(cats);
        });

  }

  seleccionarFoto(event: any) {
    this.fotoSeleccionada = event.target.files[0];
    this.progreso = 0;
    console.log(this.fotoSeleccionada);
  }

  subirFoto() {
      this.produitService.subirFoto(this.fotoSeleccionada, this.newProduit.idProduit)
        .subscribe(event => {
          if (event.type === HttpEventType.UploadProgress) {
            // this.progreso = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            let response: any = event.body;
            this.newProduit = response.newProduit as Produit;

          }
        });
  }


  addProduit(){
    this.newProduit.categorie = this.categories.find(cat => cat.idCat == this.newIdCat)!;
    this.produitService.ajouterProduit(this.newProduit)
                      .subscribe(prod => {
                      console.log(prod);
                      this.router.navigate(['produits']);
                      });
    }




}
