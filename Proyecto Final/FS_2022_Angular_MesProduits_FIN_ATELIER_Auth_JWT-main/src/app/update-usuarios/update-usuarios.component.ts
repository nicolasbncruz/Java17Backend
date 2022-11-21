import { HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../model/categorie.model';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-update-usuarios',
  templateUrl: './update-usuarios.component.html',
  styleUrls: ['./update-usuarios.component.css']
})
export class UpdateUsuariosComponent implements OnInit {

  private fotoSeleccionada: File;
  progreso: number = 0;
  currentProduit = new Produit();
  categories! : Categorie[];
  updatedCatId! : number;

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private produitService: ProduitService) { }

  ngOnInit(): void {
    this.produitService.listeCategories().
    subscribe(cats => {this.categories = cats._embedded.categories;
    console.log(cats);
    });


    this.produitService.consulterProduit(this.activatedRoute.snapshot.params['id']).
    subscribe( prod =>{ this.currentProduit = prod;
      this.updatedCatId =   this.currentProduit.categorie.idCat;

    } ) ;
  }

  seleccionarFoto(event: any) {
    this.fotoSeleccionada = event.target.files[0];
    this.progreso = 0;
    console.log(this.fotoSeleccionada);
  }

  subirFoto() {
      this.produitService.subirFoto(this.fotoSeleccionada, this.currentProduit.idProduit)
        .subscribe(event => {
          if (event.type === HttpEventType.UploadProgress) {
            // this.progreso = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            let response: any = event.body;
            this.currentProduit = response.currentProduit as Produit;

          }
        });
  }


updateProduit() {
  this.currentProduit.categorie = this.categories.find(cat => cat.idCat == this.updatedCatId)!;
       this.produitService.updateProduit(this.currentProduit).subscribe(prod => {
    this.router.navigate(['produits']); }
    );
}

}
