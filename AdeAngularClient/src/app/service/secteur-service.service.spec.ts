import { TestBed } from '@angular/core/testing';

import { SecteurService } from './secteur-service.service';

describe('SecteurServiceService', () => {
  let service: SecteurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecteurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
