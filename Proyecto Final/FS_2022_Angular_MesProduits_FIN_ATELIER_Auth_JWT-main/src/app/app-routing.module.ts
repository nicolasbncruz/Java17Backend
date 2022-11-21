import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProduitComponent } from './add-produit/add-produit.component';
import { AddUsuariosComponent } from './add-usuarios/add-usuarios.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { ListeCategoriesComponent } from './liste-categories/liste-categories.component';
import { LoginComponent } from './login/login.component';
import { ProduitGuard } from './produit.guard';
import { ProduitsComponent } from './produits/produits.component';
import { RechercheParCategorieComponent } from './recherche-par-categorie/recherche-par-categorie.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { UpdateUsuariosComponent } from './update-usuarios/update-usuarios.component';
import { UsuariosComponent } from './usuarios/usuarios.component';



const routes: Routes = [
  {path: "produits", component : ProduitsComponent},
  {path: "usuarios", component : UsuariosComponent},
  {path: "add-produit", component : AddProduitComponent, canActivate:[ProduitGuard]},
  {path: "add-usuarios", component : AddUsuariosComponent, canActivate:[ProduitGuard]},
  {path: "updateProduit/:id", component: UpdateProduitComponent},
  {path: "updateUsuario/:id", component: UpdateUsuariosComponent},
  {path: "rechercheParCategorie", component : RechercheParCategorieComponent},
  {path: "rechercheParNom", component : RechercheParNomComponent},
  {path: "listeCategories", component : ListeCategoriesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'app-forbidden', component: ForbiddenComponent},
  {path: "", redirectTo: "produits", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
