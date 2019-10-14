import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatGridListModule,
    MatExpansionModule,
    MatTableModule
  ],
  exports: [
    MatGridListModule,
    MatExpansionModule,
    MatTableModule
  ]
})
export class MaterialModule { }
