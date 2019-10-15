import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    MatGridListModule,
    MatExpansionModule,
    MatTableModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule
  ],
  imports: [
    
    MatGridListModule,
    MatExpansionModule,
    MatTableModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule
  ],
  exports: [
    MatGridListModule,
    MatExpansionModule,
    MatTableModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule
  ]
})
export class MaterialModule { }
